package cn.huaruan.ud24.query.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodaysWaybillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TodaysWaybillExample() {
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

        public Criteria andTdNoIsNull() {
            addCriterion("td_no is null");
            return (Criteria) this;
        }

        public Criteria andTdNoIsNotNull() {
            addCriterion("td_no is not null");
            return (Criteria) this;
        }

        public Criteria andTdNoEqualTo(String value) {
            addCriterion("td_no =", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoNotEqualTo(String value) {
            addCriterion("td_no <>", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoGreaterThan(String value) {
            addCriterion("td_no >", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoGreaterThanOrEqualTo(String value) {
            addCriterion("td_no >=", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoLessThan(String value) {
            addCriterion("td_no <", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoLessThanOrEqualTo(String value) {
            addCriterion("td_no <=", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoLike(String value) {
            addCriterion("td_no like", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoNotLike(String value) {
            addCriterion("td_no not like", value, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoIn(List<String> values) {
            addCriterion("td_no in", values, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoNotIn(List<String> values) {
            addCriterion("td_no not in", values, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoBetween(String value1, String value2) {
            addCriterion("td_no between", value1, value2, "tdNo");
            return (Criteria) this;
        }

        public Criteria andTdNoNotBetween(String value1, String value2) {
            addCriterion("td_no not between", value1, value2, "tdNo");
            return (Criteria) this;
        }

        public Criteria andDestCodeIsNull() {
            addCriterion("dest_code is null");
            return (Criteria) this;
        }

        public Criteria andDestCodeIsNotNull() {
            addCriterion("dest_code is not null");
            return (Criteria) this;
        }

        public Criteria andDestCodeEqualTo(String value) {
            addCriterion("dest_code =", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeNotEqualTo(String value) {
            addCriterion("dest_code <>", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeGreaterThan(String value) {
            addCriterion("dest_code >", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dest_code >=", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeLessThan(String value) {
            addCriterion("dest_code <", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeLessThanOrEqualTo(String value) {
            addCriterion("dest_code <=", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeLike(String value) {
            addCriterion("dest_code like", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeNotLike(String value) {
            addCriterion("dest_code not like", value, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeIn(List<String> values) {
            addCriterion("dest_code in", values, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeNotIn(List<String> values) {
            addCriterion("dest_code not in", values, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeBetween(String value1, String value2) {
            addCriterion("dest_code between", value1, value2, "destCode");
            return (Criteria) this;
        }

        public Criteria andDestCodeNotBetween(String value1, String value2) {
            addCriterion("dest_code not between", value1, value2, "destCode");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdIsNull() {
            addCriterion("start_org_id is null");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdIsNotNull() {
            addCriterion("start_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdEqualTo(String value) {
            addCriterion("start_org_id =", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdNotEqualTo(String value) {
            addCriterion("start_org_id <>", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdGreaterThan(String value) {
            addCriterion("start_org_id >", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("start_org_id >=", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdLessThan(String value) {
            addCriterion("start_org_id <", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdLessThanOrEqualTo(String value) {
            addCriterion("start_org_id <=", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdLike(String value) {
            addCriterion("start_org_id like", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdNotLike(String value) {
            addCriterion("start_org_id not like", value, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdIn(List<String> values) {
            addCriterion("start_org_id in", values, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdNotIn(List<String> values) {
            addCriterion("start_org_id not in", values, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdBetween(String value1, String value2) {
            addCriterion("start_org_id between", value1, value2, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andStartOrgIdNotBetween(String value1, String value2) {
            addCriterion("start_org_id not between", value1, value2, "startOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdIsNull() {
            addCriterion("dest_org_id is null");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdIsNotNull() {
            addCriterion("dest_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdEqualTo(String value) {
            addCriterion("dest_org_id =", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdNotEqualTo(String value) {
            addCriterion("dest_org_id <>", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdGreaterThan(String value) {
            addCriterion("dest_org_id >", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("dest_org_id >=", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdLessThan(String value) {
            addCriterion("dest_org_id <", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdLessThanOrEqualTo(String value) {
            addCriterion("dest_org_id <=", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdLike(String value) {
            addCriterion("dest_org_id like", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdNotLike(String value) {
            addCriterion("dest_org_id not like", value, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdIn(List<String> values) {
            addCriterion("dest_org_id in", values, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdNotIn(List<String> values) {
            addCriterion("dest_org_id not in", values, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdBetween(String value1, String value2) {
            addCriterion("dest_org_id between", value1, value2, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andDestOrgIdNotBetween(String value1, String value2) {
            addCriterion("dest_org_id not between", value1, value2, "destOrgId");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (Criteria) this;
        }

        public Criteria andSourceTypeEqualTo(Integer value) {
            addCriterion("source_type =", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotEqualTo(Integer value) {
            addCriterion("source_type <>", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThan(Integer value) {
            addCriterion("source_type >", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_type >=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThan(Integer value) {
            addCriterion("source_type <", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("source_type <=", value, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeIn(List<Integer> values) {
            addCriterion("source_type in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotIn(List<Integer> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIsNull() {
            addCriterion("sender_phone is null");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIsNotNull() {
            addCriterion("sender_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneEqualTo(String value) {
            addCriterion("sender_phone =", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotEqualTo(String value) {
            addCriterion("sender_phone <>", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneGreaterThan(String value) {
            addCriterion("sender_phone >", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sender_phone >=", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLessThan(String value) {
            addCriterion("sender_phone <", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLessThanOrEqualTo(String value) {
            addCriterion("sender_phone <=", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneLike(String value) {
            addCriterion("sender_phone like", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotLike(String value) {
            addCriterion("sender_phone not like", value, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneIn(List<String> values) {
            addCriterion("sender_phone in", values, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotIn(List<String> values) {
            addCriterion("sender_phone not in", values, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneBetween(String value1, String value2) {
            addCriterion("sender_phone between", value1, value2, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderPhoneNotBetween(String value1, String value2) {
            addCriterion("sender_phone not between", value1, value2, "senderPhone");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIsNull() {
            addCriterion("sender_address is null");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIsNotNull() {
            addCriterion("sender_address is not null");
            return (Criteria) this;
        }

        public Criteria andSenderAddressEqualTo(String value) {
            addCriterion("sender_address =", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotEqualTo(String value) {
            addCriterion("sender_address <>", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressGreaterThan(String value) {
            addCriterion("sender_address >", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sender_address >=", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLessThan(String value) {
            addCriterion("sender_address <", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLessThanOrEqualTo(String value) {
            addCriterion("sender_address <=", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressLike(String value) {
            addCriterion("sender_address like", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotLike(String value) {
            addCriterion("sender_address not like", value, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressIn(List<String> values) {
            addCriterion("sender_address in", values, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotIn(List<String> values) {
            addCriterion("sender_address not in", values, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressBetween(String value1, String value2) {
            addCriterion("sender_address between", value1, value2, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderAddressNotBetween(String value1, String value2) {
            addCriterion("sender_address not between", value1, value2, "senderAddress");
            return (Criteria) this;
        }

        public Criteria andSenderLocationIsNull() {
            addCriterion("sender_location is null");
            return (Criteria) this;
        }

        public Criteria andSenderLocationIsNotNull() {
            addCriterion("sender_location is not null");
            return (Criteria) this;
        }

        public Criteria andSenderLocationEqualTo(Object value) {
            addCriterion("sender_location =", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationNotEqualTo(Object value) {
            addCriterion("sender_location <>", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationGreaterThan(Object value) {
            addCriterion("sender_location >", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationGreaterThanOrEqualTo(Object value) {
            addCriterion("sender_location >=", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationLessThan(Object value) {
            addCriterion("sender_location <", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationLessThanOrEqualTo(Object value) {
            addCriterion("sender_location <=", value, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationIn(List<Object> values) {
            addCriterion("sender_location in", values, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationNotIn(List<Object> values) {
            addCriterion("sender_location not in", values, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationBetween(Object value1, Object value2) {
            addCriterion("sender_location between", value1, value2, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andSenderLocationNotBetween(Object value1, Object value2) {
            addCriterion("sender_location not between", value1, value2, "senderLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationIsNull() {
            addCriterion("receiver_location is null");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationIsNotNull() {
            addCriterion("receiver_location is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationEqualTo(Object value) {
            addCriterion("receiver_location =", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationNotEqualTo(Object value) {
            addCriterion("receiver_location <>", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationGreaterThan(Object value) {
            addCriterion("receiver_location >", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationGreaterThanOrEqualTo(Object value) {
            addCriterion("receiver_location >=", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationLessThan(Object value) {
            addCriterion("receiver_location <", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationLessThanOrEqualTo(Object value) {
            addCriterion("receiver_location <=", value, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationIn(List<Object> values) {
            addCriterion("receiver_location in", values, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationNotIn(List<Object> values) {
            addCriterion("receiver_location not in", values, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationBetween(Object value1, Object value2) {
            addCriterion("receiver_location between", value1, value2, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andReceiverLocationNotBetween(Object value1, Object value2) {
            addCriterion("receiver_location not between", value1, value2, "receiverLocation");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNull() {
            addCriterion("goods_weight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNotNull() {
            addCriterion("goods_weight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightEqualTo(BigDecimal value) {
            addCriterion("goods_weight =", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotEqualTo(BigDecimal value) {
            addCriterion("goods_weight <>", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThan(BigDecimal value) {
            addCriterion("goods_weight >", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_weight >=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThan(BigDecimal value) {
            addCriterion("goods_weight <", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_weight <=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIn(List<BigDecimal> values) {
            addCriterion("goods_weight in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotIn(List<BigDecimal> values) {
            addCriterion("goods_weight not in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_weight between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_weight not between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNull() {
            addCriterion("goods_info is null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIsNotNull() {
            addCriterion("goods_info is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoEqualTo(String value) {
            addCriterion("goods_info =", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotEqualTo(String value) {
            addCriterion("goods_info <>", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThan(String value) {
            addCriterion("goods_info >", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_info >=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThan(String value) {
            addCriterion("goods_info <", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLessThanOrEqualTo(String value) {
            addCriterion("goods_info <=", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoLike(String value) {
            addCriterion("goods_info like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotLike(String value) {
            addCriterion("goods_info not like", value, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoIn(List<String> values) {
            addCriterion("goods_info in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotIn(List<String> values) {
            addCriterion("goods_info not in", values, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoBetween(String value1, String value2) {
            addCriterion("goods_info between", value1, value2, "goodsInfo");
            return (Criteria) this;
        }

        public Criteria andGoodsInfoNotBetween(String value1, String value2) {
            addCriterion("goods_info not between", value1, value2, "goodsInfo");
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

        public Criteria andExpectArriveTimeIsNull() {
            addCriterion("expect_arrive_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeIsNotNull() {
            addCriterion("expect_arrive_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeEqualTo(String value) {
            addCriterion("expect_arrive_time =", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeNotEqualTo(String value) {
            addCriterion("expect_arrive_time <>", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeGreaterThan(String value) {
            addCriterion("expect_arrive_time >", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("expect_arrive_time >=", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeLessThan(String value) {
            addCriterion("expect_arrive_time <", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeLessThanOrEqualTo(String value) {
            addCriterion("expect_arrive_time <=", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeLike(String value) {
            addCriterion("expect_arrive_time like", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeNotLike(String value) {
            addCriterion("expect_arrive_time not like", value, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeIn(List<String> values) {
            addCriterion("expect_arrive_time in", values, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeNotIn(List<String> values) {
            addCriterion("expect_arrive_time not in", values, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeBetween(String value1, String value2) {
            addCriterion("expect_arrive_time between", value1, value2, "expectArriveTime");
            return (Criteria) this;
        }

        public Criteria andExpectArriveTimeNotBetween(String value1, String value2) {
            addCriterion("expect_arrive_time not between", value1, value2, "expectArriveTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Boolean value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Boolean value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Boolean value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Boolean value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Boolean> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Boolean> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNull() {
            addCriterion("confirm is null");
            return (Criteria) this;
        }

        public Criteria andConfirmIsNotNull() {
            addCriterion("confirm is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmEqualTo(Boolean value) {
            addCriterion("confirm =", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotEqualTo(Boolean value) {
            addCriterion("confirm <>", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThan(Boolean value) {
            addCriterion("confirm >", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("confirm >=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThan(Boolean value) {
            addCriterion("confirm <", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmLessThanOrEqualTo(Boolean value) {
            addCriterion("confirm <=", value, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmIn(List<Boolean> values) {
            addCriterion("confirm in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotIn(List<Boolean> values) {
            addCriterion("confirm not in", values, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmBetween(Boolean value1, Boolean value2) {
            addCriterion("confirm between", value1, value2, "confirm");
            return (Criteria) this;
        }

        public Criteria andConfirmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("confirm not between", value1, value2, "confirm");
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

        public Criteria andThirdPartNoIsNull() {
            addCriterion("third_part_no is null");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoIsNotNull() {
            addCriterion("third_part_no is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoEqualTo(String value) {
            addCriterion("third_part_no =", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoNotEqualTo(String value) {
            addCriterion("third_part_no <>", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoGreaterThan(String value) {
            addCriterion("third_part_no >", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoGreaterThanOrEqualTo(String value) {
            addCriterion("third_part_no >=", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoLessThan(String value) {
            addCriterion("third_part_no <", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoLessThanOrEqualTo(String value) {
            addCriterion("third_part_no <=", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoLike(String value) {
            addCriterion("third_part_no like", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoNotLike(String value) {
            addCriterion("third_part_no not like", value, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoIn(List<String> values) {
            addCriterion("third_part_no in", values, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoNotIn(List<String> values) {
            addCriterion("third_part_no not in", values, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoBetween(String value1, String value2) {
            addCriterion("third_part_no between", value1, value2, "thirdPartNo");
            return (Criteria) this;
        }

        public Criteria andThirdPartNoNotBetween(String value1, String value2) {
            addCriterion("third_part_no not between", value1, value2, "thirdPartNo");
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