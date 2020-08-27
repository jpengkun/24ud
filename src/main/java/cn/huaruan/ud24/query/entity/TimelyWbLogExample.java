package cn.huaruan.ud24.query.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimelyWbLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimelyWbLogExample() {
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

        public Criteria andWbIdIsNull() {
            addCriterion("wb_id is null");
            return (Criteria) this;
        }

        public Criteria andWbIdIsNotNull() {
            addCriterion("wb_id is not null");
            return (Criteria) this;
        }

        public Criteria andWbIdEqualTo(String value) {
            addCriterion("wb_id =", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotEqualTo(String value) {
            addCriterion("wb_id <>", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdGreaterThan(String value) {
            addCriterion("wb_id >", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdGreaterThanOrEqualTo(String value) {
            addCriterion("wb_id >=", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdLessThan(String value) {
            addCriterion("wb_id <", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdLessThanOrEqualTo(String value) {
            addCriterion("wb_id <=", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdLike(String value) {
            addCriterion("wb_id like", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotLike(String value) {
            addCriterion("wb_id not like", value, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdIn(List<String> values) {
            addCriterion("wb_id in", values, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotIn(List<String> values) {
            addCriterion("wb_id not in", values, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdBetween(String value1, String value2) {
            addCriterion("wb_id between", value1, value2, "wbId");
            return (Criteria) this;
        }

        public Criteria andWbIdNotBetween(String value1, String value2) {
            addCriterion("wb_id not between", value1, value2, "wbId");
            return (Criteria) this;
        }

        public Criteria andCourierIdIsNull() {
            addCriterion("courier_id is null");
            return (Criteria) this;
        }

        public Criteria andCourierIdIsNotNull() {
            addCriterion("courier_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourierIdEqualTo(String value) {
            addCriterion("courier_id =", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdNotEqualTo(String value) {
            addCriterion("courier_id <>", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdGreaterThan(String value) {
            addCriterion("courier_id >", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdGreaterThanOrEqualTo(String value) {
            addCriterion("courier_id >=", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdLessThan(String value) {
            addCriterion("courier_id <", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdLessThanOrEqualTo(String value) {
            addCriterion("courier_id <=", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdLike(String value) {
            addCriterion("courier_id like", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdNotLike(String value) {
            addCriterion("courier_id not like", value, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdIn(List<String> values) {
            addCriterion("courier_id in", values, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdNotIn(List<String> values) {
            addCriterion("courier_id not in", values, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdBetween(String value1, String value2) {
            addCriterion("courier_id between", value1, value2, "courierId");
            return (Criteria) this;
        }

        public Criteria andCourierIdNotBetween(String value1, String value2) {
            addCriterion("courier_id not between", value1, value2, "courierId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIsNull() {
            addCriterion("abnormal_type is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIsNotNull() {
            addCriterion("abnormal_type is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeEqualTo(String value) {
            addCriterion("abnormal_type =", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotEqualTo(String value) {
            addCriterion("abnormal_type <>", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeGreaterThan(String value) {
            addCriterion("abnormal_type >", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("abnormal_type >=", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLessThan(String value) {
            addCriterion("abnormal_type <", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLessThanOrEqualTo(String value) {
            addCriterion("abnormal_type <=", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeLike(String value) {
            addCriterion("abnormal_type like", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotLike(String value) {
            addCriterion("abnormal_type not like", value, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeIn(List<String> values) {
            addCriterion("abnormal_type in", values, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotIn(List<String> values) {
            addCriterion("abnormal_type not in", values, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeBetween(String value1, String value2) {
            addCriterion("abnormal_type between", value1, value2, "abnormalType");
            return (Criteria) this;
        }

        public Criteria andAbnormalTypeNotBetween(String value1, String value2) {
            addCriterion("abnormal_type not between", value1, value2, "abnormalType");
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