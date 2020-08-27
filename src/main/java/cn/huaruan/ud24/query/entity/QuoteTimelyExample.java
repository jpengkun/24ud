package cn.huaruan.ud24.query.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuoteTimelyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuoteTimelyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWeightMethodIsNull() {
            addCriterion("weight_method is null");
            return (Criteria) this;
        }

        public Criteria andWeightMethodIsNotNull() {
            addCriterion("weight_method is not null");
            return (Criteria) this;
        }

        public Criteria andWeightMethodEqualTo(Integer value) {
            addCriterion("weight_method =", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodNotEqualTo(Integer value) {
            addCriterion("weight_method <>", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodGreaterThan(Integer value) {
            addCriterion("weight_method >", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_method >=", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodLessThan(Integer value) {
            addCriterion("weight_method <", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodLessThanOrEqualTo(Integer value) {
            addCriterion("weight_method <=", value, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodIn(List<Integer> values) {
            addCriterion("weight_method in", values, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodNotIn(List<Integer> values) {
            addCriterion("weight_method not in", values, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodBetween(Integer value1, Integer value2) {
            addCriterion("weight_method between", value1, value2, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andWeightMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_method not between", value1, value2, "weightMethod");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNull() {
            addCriterion("base_price is null");
            return (Criteria) this;
        }

        public Criteria andBasePriceIsNotNull() {
            addCriterion("base_price is not null");
            return (Criteria) this;
        }

        public Criteria andBasePriceEqualTo(BigDecimal value) {
            addCriterion("base_price =", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotEqualTo(BigDecimal value) {
            addCriterion("base_price <>", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThan(BigDecimal value) {
            addCriterion("base_price >", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_price >=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThan(BigDecimal value) {
            addCriterion("base_price <", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_price <=", value, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceIn(List<BigDecimal> values) {
            addCriterion("base_price in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotIn(List<BigDecimal> values) {
            addCriterion("base_price not in", values, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_price between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andBasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_price not between", value1, value2, "basePrice");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNull() {
            addCriterion("first_weight is null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNotNull() {
            addCriterion("first_weight is not null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightEqualTo(BigDecimal value) {
            addCriterion("first_weight =", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotEqualTo(BigDecimal value) {
            addCriterion("first_weight <>", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThan(BigDecimal value) {
            addCriterion("first_weight >", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_weight >=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThan(BigDecimal value) {
            addCriterion("first_weight <", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_weight <=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIn(List<BigDecimal> values) {
            addCriterion("first_weight in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotIn(List<BigDecimal> values) {
            addCriterion("first_weight not in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_weight between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_weight not between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightIsNull() {
            addCriterion("additional_weight is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightIsNotNull() {
            addCriterion("additional_weight is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightEqualTo(BigDecimal value) {
            addCriterion("additional_weight =", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightNotEqualTo(BigDecimal value) {
            addCriterion("additional_weight <>", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightGreaterThan(BigDecimal value) {
            addCriterion("additional_weight >", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_weight >=", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightLessThan(BigDecimal value) {
            addCriterion("additional_weight <", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_weight <=", value, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightIn(List<BigDecimal> values) {
            addCriterion("additional_weight in", values, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightNotIn(List<BigDecimal> values) {
            addCriterion("additional_weight not in", values, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_weight between", value1, value2, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andAdditionalWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_weight not between", value1, value2, "additionalWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightIsNull() {
            addCriterion("top_weight is null");
            return (Criteria) this;
        }

        public Criteria andTopWeightIsNotNull() {
            addCriterion("top_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTopWeightEqualTo(BigDecimal value) {
            addCriterion("top_weight =", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightNotEqualTo(BigDecimal value) {
            addCriterion("top_weight <>", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightGreaterThan(BigDecimal value) {
            addCriterion("top_weight >", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("top_weight >=", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightLessThan(BigDecimal value) {
            addCriterion("top_weight <", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("top_weight <=", value, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightIn(List<BigDecimal> values) {
            addCriterion("top_weight in", values, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightNotIn(List<BigDecimal> values) {
            addCriterion("top_weight not in", values, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("top_weight between", value1, value2, "topWeight");
            return (Criteria) this;
        }

        public Criteria andTopWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("top_weight not between", value1, value2, "topWeight");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceIsNull() {
            addCriterion("first_distance is null");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceIsNotNull() {
            addCriterion("first_distance is not null");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceEqualTo(BigDecimal value) {
            addCriterion("first_distance =", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceNotEqualTo(BigDecimal value) {
            addCriterion("first_distance <>", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceGreaterThan(BigDecimal value) {
            addCriterion("first_distance >", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_distance >=", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceLessThan(BigDecimal value) {
            addCriterion("first_distance <", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_distance <=", value, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceIn(List<BigDecimal> values) {
            addCriterion("first_distance in", values, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceNotIn(List<BigDecimal> values) {
            addCriterion("first_distance not in", values, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_distance between", value1, value2, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_distance not between", value1, value2, "firstDistance");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceIsNull() {
            addCriterion("first_distance_price is null");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceIsNotNull() {
            addCriterion("first_distance_price is not null");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceEqualTo(BigDecimal value) {
            addCriterion("first_distance_price =", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceNotEqualTo(BigDecimal value) {
            addCriterion("first_distance_price <>", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceGreaterThan(BigDecimal value) {
            addCriterion("first_distance_price >", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_distance_price >=", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceLessThan(BigDecimal value) {
            addCriterion("first_distance_price <", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_distance_price <=", value, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceIn(List<BigDecimal> values) {
            addCriterion("first_distance_price in", values, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceNotIn(List<BigDecimal> values) {
            addCriterion("first_distance_price not in", values, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_distance_price between", value1, value2, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andFirstDistancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_distance_price not between", value1, value2, "firstDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceIsNull() {
            addCriterion("second_distance is null");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceIsNotNull() {
            addCriterion("second_distance is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceEqualTo(BigDecimal value) {
            addCriterion("second_distance =", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceNotEqualTo(BigDecimal value) {
            addCriterion("second_distance <>", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceGreaterThan(BigDecimal value) {
            addCriterion("second_distance >", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_distance >=", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceLessThan(BigDecimal value) {
            addCriterion("second_distance <", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_distance <=", value, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceIn(List<BigDecimal> values) {
            addCriterion("second_distance in", values, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceNotIn(List<BigDecimal> values) {
            addCriterion("second_distance not in", values, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_distance between", value1, value2, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_distance not between", value1, value2, "secondDistance");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceIsNull() {
            addCriterion("second_distance_price is null");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceIsNotNull() {
            addCriterion("second_distance_price is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceEqualTo(BigDecimal value) {
            addCriterion("second_distance_price =", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceNotEqualTo(BigDecimal value) {
            addCriterion("second_distance_price <>", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceGreaterThan(BigDecimal value) {
            addCriterion("second_distance_price >", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("second_distance_price >=", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceLessThan(BigDecimal value) {
            addCriterion("second_distance_price <", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("second_distance_price <=", value, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceIn(List<BigDecimal> values) {
            addCriterion("second_distance_price in", values, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceNotIn(List<BigDecimal> values) {
            addCriterion("second_distance_price not in", values, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_distance_price between", value1, value2, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andSecondDistancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("second_distance_price not between", value1, value2, "secondDistancePrice");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceIsNull() {
            addCriterion("additional_distance is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceIsNotNull() {
            addCriterion("additional_distance is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceEqualTo(BigDecimal value) {
            addCriterion("additional_distance =", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceNotEqualTo(BigDecimal value) {
            addCriterion("additional_distance <>", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceGreaterThan(BigDecimal value) {
            addCriterion("additional_distance >", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_distance >=", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceLessThan(BigDecimal value) {
            addCriterion("additional_distance <", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("additional_distance <=", value, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceIn(List<BigDecimal> values) {
            addCriterion("additional_distance in", values, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceNotIn(List<BigDecimal> values) {
            addCriterion("additional_distance not in", values, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_distance between", value1, value2, "additionalDistance");
            return (Criteria) this;
        }

        public Criteria andAdditionalDistanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("additional_distance not between", value1, value2, "additionalDistance");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}