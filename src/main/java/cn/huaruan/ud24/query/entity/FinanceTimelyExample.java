package cn.huaruan.ud24.query.entity;

import java.util.ArrayList;
import java.util.List;

public class FinanceTimelyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceTimelyExample() {
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

        public Criteria andTimelyIdIsNull() {
            addCriterion("timely_id is null");
            return (Criteria) this;
        }

        public Criteria andTimelyIdIsNotNull() {
            addCriterion("timely_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimelyIdEqualTo(String value) {
            addCriterion("timely_id =", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdNotEqualTo(String value) {
            addCriterion("timely_id <>", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdGreaterThan(String value) {
            addCriterion("timely_id >", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdGreaterThanOrEqualTo(String value) {
            addCriterion("timely_id >=", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdLessThan(String value) {
            addCriterion("timely_id <", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdLessThanOrEqualTo(String value) {
            addCriterion("timely_id <=", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdLike(String value) {
            addCriterion("timely_id like", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdNotLike(String value) {
            addCriterion("timely_id not like", value, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdIn(List<String> values) {
            addCriterion("timely_id in", values, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdNotIn(List<String> values) {
            addCriterion("timely_id not in", values, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdBetween(String value1, String value2) {
            addCriterion("timely_id between", value1, value2, "timelyId");
            return (Criteria) this;
        }

        public Criteria andTimelyIdNotBetween(String value1, String value2) {
            addCriterion("timely_id not between", value1, value2, "timelyId");
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

        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(Double value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(Double value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(Double value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(Double value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(Double value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(Double value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<Double> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<Double> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(Double value1, Double value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(Double value1, Double value2) {
            addCriterion("site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andCourierIsNull() {
            addCriterion("courier is null");
            return (Criteria) this;
        }

        public Criteria andCourierIsNotNull() {
            addCriterion("courier is not null");
            return (Criteria) this;
        }

        public Criteria andCourierEqualTo(Double value) {
            addCriterion("courier =", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotEqualTo(Double value) {
            addCriterion("courier <>", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierGreaterThan(Double value) {
            addCriterion("courier >", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierGreaterThanOrEqualTo(Double value) {
            addCriterion("courier >=", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierLessThan(Double value) {
            addCriterion("courier <", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierLessThanOrEqualTo(Double value) {
            addCriterion("courier <=", value, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierIn(List<Double> values) {
            addCriterion("courier in", values, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotIn(List<Double> values) {
            addCriterion("courier not in", values, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierBetween(Double value1, Double value2) {
            addCriterion("courier between", value1, value2, "courier");
            return (Criteria) this;
        }

        public Criteria andCourierNotBetween(Double value1, Double value2) {
            addCriterion("courier not between", value1, value2, "courier");
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