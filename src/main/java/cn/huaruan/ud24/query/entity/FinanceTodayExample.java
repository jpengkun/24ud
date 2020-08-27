package cn.huaruan.ud24.query.entity;

import java.util.ArrayList;
import java.util.List;

public class FinanceTodayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceTodayExample() {
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

        public Criteria andTodayIdIsNull() {
            addCriterion("today_id is null");
            return (Criteria) this;
        }

        public Criteria andTodayIdIsNotNull() {
            addCriterion("today_id is not null");
            return (Criteria) this;
        }

        public Criteria andTodayIdEqualTo(String value) {
            addCriterion("today_id =", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdNotEqualTo(String value) {
            addCriterion("today_id <>", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdGreaterThan(String value) {
            addCriterion("today_id >", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdGreaterThanOrEqualTo(String value) {
            addCriterion("today_id >=", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdLessThan(String value) {
            addCriterion("today_id <", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdLessThanOrEqualTo(String value) {
            addCriterion("today_id <=", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdLike(String value) {
            addCriterion("today_id like", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdNotLike(String value) {
            addCriterion("today_id not like", value, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdIn(List<String> values) {
            addCriterion("today_id in", values, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdNotIn(List<String> values) {
            addCriterion("today_id not in", values, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdBetween(String value1, String value2) {
            addCriterion("today_id between", value1, value2, "todayId");
            return (Criteria) this;
        }

        public Criteria andTodayIdNotBetween(String value1, String value2) {
            addCriterion("today_id not between", value1, value2, "todayId");
            return (Criteria) this;
        }

        public Criteria andCenterIsNull() {
            addCriterion("center is null");
            return (Criteria) this;
        }

        public Criteria andCenterIsNotNull() {
            addCriterion("center is not null");
            return (Criteria) this;
        }

        public Criteria andCenterEqualTo(Double value) {
            addCriterion("center =", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterNotEqualTo(Double value) {
            addCriterion("center <>", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterGreaterThan(Double value) {
            addCriterion("center >", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterGreaterThanOrEqualTo(Double value) {
            addCriterion("center >=", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterLessThan(Double value) {
            addCriterion("center <", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterLessThanOrEqualTo(Double value) {
            addCriterion("center <=", value, "center");
            return (Criteria) this;
        }

        public Criteria andCenterIn(List<Double> values) {
            addCriterion("center in", values, "center");
            return (Criteria) this;
        }

        public Criteria andCenterNotIn(List<Double> values) {
            addCriterion("center not in", values, "center");
            return (Criteria) this;
        }

        public Criteria andCenterBetween(Double value1, Double value2) {
            addCriterion("center between", value1, value2, "center");
            return (Criteria) this;
        }

        public Criteria andCenterNotBetween(Double value1, Double value2) {
            addCriterion("center not between", value1, value2, "center");
            return (Criteria) this;
        }

        public Criteria andAllocationIsNull() {
            addCriterion("allocation is null");
            return (Criteria) this;
        }

        public Criteria andAllocationIsNotNull() {
            addCriterion("allocation is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationEqualTo(Double value) {
            addCriterion("allocation =", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotEqualTo(Double value) {
            addCriterion("allocation <>", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationGreaterThan(Double value) {
            addCriterion("allocation >", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationGreaterThanOrEqualTo(Double value) {
            addCriterion("allocation >=", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationLessThan(Double value) {
            addCriterion("allocation <", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationLessThanOrEqualTo(Double value) {
            addCriterion("allocation <=", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationIn(List<Double> values) {
            addCriterion("allocation in", values, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotIn(List<Double> values) {
            addCriterion("allocation not in", values, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationBetween(Double value1, Double value2) {
            addCriterion("allocation between", value1, value2, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotBetween(Double value1, Double value2) {
            addCriterion("allocation not between", value1, value2, "allocation");
            return (Criteria) this;
        }

        public Criteria andSendSiteIsNull() {
            addCriterion("send_site is null");
            return (Criteria) this;
        }

        public Criteria andSendSiteIsNotNull() {
            addCriterion("send_site is not null");
            return (Criteria) this;
        }

        public Criteria andSendSiteEqualTo(Double value) {
            addCriterion("send_site =", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteNotEqualTo(Double value) {
            addCriterion("send_site <>", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteGreaterThan(Double value) {
            addCriterion("send_site >", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteGreaterThanOrEqualTo(Double value) {
            addCriterion("send_site >=", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteLessThan(Double value) {
            addCriterion("send_site <", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteLessThanOrEqualTo(Double value) {
            addCriterion("send_site <=", value, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteIn(List<Double> values) {
            addCriterion("send_site in", values, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteNotIn(List<Double> values) {
            addCriterion("send_site not in", values, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteBetween(Double value1, Double value2) {
            addCriterion("send_site between", value1, value2, "sendSite");
            return (Criteria) this;
        }

        public Criteria andSendSiteNotBetween(Double value1, Double value2) {
            addCriterion("send_site not between", value1, value2, "sendSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteIsNull() {
            addCriterion("receive_site is null");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteIsNotNull() {
            addCriterion("receive_site is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteEqualTo(Double value) {
            addCriterion("receive_site =", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteNotEqualTo(Double value) {
            addCriterion("receive_site <>", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteGreaterThan(Double value) {
            addCriterion("receive_site >", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteGreaterThanOrEqualTo(Double value) {
            addCriterion("receive_site >=", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteLessThan(Double value) {
            addCriterion("receive_site <", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteLessThanOrEqualTo(Double value) {
            addCriterion("receive_site <=", value, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteIn(List<Double> values) {
            addCriterion("receive_site in", values, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteNotIn(List<Double> values) {
            addCriterion("receive_site not in", values, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteBetween(Double value1, Double value2) {
            addCriterion("receive_site between", value1, value2, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andReceiveSiteNotBetween(Double value1, Double value2) {
            addCriterion("receive_site not between", value1, value2, "receiveSite");
            return (Criteria) this;
        }

        public Criteria andPickerIsNull() {
            addCriterion("picker is null");
            return (Criteria) this;
        }

        public Criteria andPickerIsNotNull() {
            addCriterion("picker is not null");
            return (Criteria) this;
        }

        public Criteria andPickerEqualTo(Double value) {
            addCriterion("picker =", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotEqualTo(Double value) {
            addCriterion("picker <>", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThan(Double value) {
            addCriterion("picker >", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThanOrEqualTo(Double value) {
            addCriterion("picker >=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThan(Double value) {
            addCriterion("picker <", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThanOrEqualTo(Double value) {
            addCriterion("picker <=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerIn(List<Double> values) {
            addCriterion("picker in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotIn(List<Double> values) {
            addCriterion("picker not in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerBetween(Double value1, Double value2) {
            addCriterion("picker between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotBetween(Double value1, Double value2) {
            addCriterion("picker not between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andDeliverIsNull() {
            addCriterion("deliver is null");
            return (Criteria) this;
        }

        public Criteria andDeliverIsNotNull() {
            addCriterion("deliver is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverEqualTo(Double value) {
            addCriterion("deliver =", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotEqualTo(Double value) {
            addCriterion("deliver <>", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverGreaterThan(Double value) {
            addCriterion("deliver >", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverGreaterThanOrEqualTo(Double value) {
            addCriterion("deliver >=", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverLessThan(Double value) {
            addCriterion("deliver <", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverLessThanOrEqualTo(Double value) {
            addCriterion("deliver <=", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverIn(List<Double> values) {
            addCriterion("deliver in", values, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotIn(List<Double> values) {
            addCriterion("deliver not in", values, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverBetween(Double value1, Double value2) {
            addCriterion("deliver between", value1, value2, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotBetween(Double value1, Double value2) {
            addCriterion("deliver not between", value1, value2, "deliver");
            return (Criteria) this;
        }

        public Criteria andTransportationIsNull() {
            addCriterion("transportation is null");
            return (Criteria) this;
        }

        public Criteria andTransportationIsNotNull() {
            addCriterion("transportation is not null");
            return (Criteria) this;
        }

        public Criteria andTransportationEqualTo(Double value) {
            addCriterion("transportation =", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotEqualTo(Double value) {
            addCriterion("transportation <>", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationGreaterThan(Double value) {
            addCriterion("transportation >", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationGreaterThanOrEqualTo(Double value) {
            addCriterion("transportation >=", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationLessThan(Double value) {
            addCriterion("transportation <", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationLessThanOrEqualTo(Double value) {
            addCriterion("transportation <=", value, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationIn(List<Double> values) {
            addCriterion("transportation in", values, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotIn(List<Double> values) {
            addCriterion("transportation not in", values, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationBetween(Double value1, Double value2) {
            addCriterion("transportation between", value1, value2, "transportation");
            return (Criteria) this;
        }

        public Criteria andTransportationNotBetween(Double value1, Double value2) {
            addCriterion("transportation not between", value1, value2, "transportation");
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