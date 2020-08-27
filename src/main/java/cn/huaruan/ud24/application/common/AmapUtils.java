package cn.huaruan.ud24.application.common;

import org.springframework.data.geo.Point;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class AmapUtils {

    static String BASE_URL = "http://restapi.amap.com/v3";
    static String KEY = "6c2845224d5f208dffba746c15b5c206";

    static String GEO = "/geocode/geo";
    static String REGEO = "/geocode/regeo";
    static String DISTRICT = "/config/district";

    private static HashMap request(String url, HashMap<String, String> params) {
        Set<String> keySet = params.keySet();
        StringBuffer requestParams = new StringBuffer();
        List<String> keyList = new ArrayList<>();
        keySet.forEach(key -> {
            requestParams.append("&" + key + "={" + key + "}");
            keyList.add(params.get(key));
        });
        HashMap result = WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
                .get().uri(url + "?" + "key=" + KEY + requestParams.toString(), (String[]) keyList.toArray(new String[keyList.size()]))
                .retrieve().bodyToMono(HashMap.class).block();
        return result;
    }

    private static HashMap<String, List<HashMap<String, String>>> requestGeocode(String address) {
        HashMap<String, List<HashMap<String, String>>> result = WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
                .get().uri("/v3/geocode/geo?key={key}&address={address}", KEY, address)
                .retrieve().bodyToMono(HashMap.class).block();
        return result;
    }

    private static HashMap<String, List<HashMap<String, String>>> requestDistrict(String address) {
        HashMap<String, List<HashMap<String, String>>> result = WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
                .get().uri("/v3/config/district?key={key}&address={address}", KEY, address)
                .retrieve().bodyToMono(HashMap.class).block();
        return result;
    }

    public static String getAreaCode(String address) {
        HashMap<String, String> params = new HashMap<>();
        params.put("address", address);
        HashMap<String, List<HashMap<String, String>>> result = request(GEO, params);
        return String.format("%04d", Integer.valueOf(result.get("geocodes").get(0).get("citycode")));
    }

    /**
     * 批量位置逆编码
     * @param addressList
     * @return
     */
    public static List<Point> batchGetLocations(List<String> addressList){
        if (null == addressList || addressList.size() == 0){
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        int remainder = addressList.size() % 10;
        int size = (addressList.size() / 10);
        for (int i = 0; i < size; i++) {
            List<String> subset = null;
            subset = addressList.subList(i * 10, (i + 1) * 10);
            result.add(subset);
        }
        if (remainder > 0) {
            List<String> subset = null;
            subset = addressList.subList(size * 10, size * 10 + remainder);
            result.add(subset);
        }
        List<Point> points = new ArrayList<>();
        result.forEach(list -> {
            List<Point> temp = getLocation(StringUtils.collectionToDelimitedString(list, "|"));
            points.addAll(temp);
        });
        return points;
    }

    /**
     * 位置逆编码
     * @param address
     * @return
     */
    public static List<Point> getLocation(String address) {
        HashMap<String, String> params = new HashMap<>();
        params.put("address", address);
        params.put("batch", "true");
        HashMap<String, List<HashMap<String, String>>> result = request(GEO, params);
        if (result == null) {
            return null;
        }

        List<HashMap<String, String>> geocodes = result.get("geocodes");
        List<Point> points = geocodes.stream().map(geocode -> {
            Point point = null;
            if (geocode.get("location") instanceof String){
                String location = geocode.get("location");
                if (StringUtils.hasText(location)) {
                    String[] split = location.split(",");
                    if (split != null && split.length > 0) {
                        point = new Point(Double.valueOf(split[0]), Double.valueOf(split[1]));
                    }
                }
            }
            return point;
        }).collect(Collectors.toList());
        return points;
    }

    public static String getPolyine(String address) {
        HashMap<String, String> params = new HashMap<>();
        params.put("address", address);
        HashMap<String, List<HashMap<String, String>>> result = request(DISTRICT, params);
        return result.get("geocodes").get(0).get("citycode");
    }

    public static String getCityCodeByPoint(Point point) {
        HashMap<String, String> params = new HashMap<>();
        params.put("location", point.getX() + "," + point.getY());
        params.put("batch", "false");
        params.put("extensions", "base");
        HashMap<String, HashMap<String, HashMap<String, String>>> result = request(REGEO, params);
        String o = result.get("regeocode").get("addressComponent").get("citycode");
        if (o instanceof String) {
            return String.format("%04d", Integer.valueOf(o));
        }
        return null;
    }

    public static String getDistrictByLocation(String x, String y) {
        HashMap<String, String> params = new HashMap<>();
        params.put("location", x + "," + y);
        params.put("batch", "false");
        params.put("extensions", "base");
        HashMap<String, HashMap<String, HashMap<String, String>>> result = request(REGEO, params);
        Object o = result.get("regeocode").get("addressComponent");
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }

}
