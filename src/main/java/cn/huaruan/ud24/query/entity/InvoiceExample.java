package cn.huaruan.ud24.query.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTaxNumIsNull() {
            addCriterion("tax_num is null");
            return (Criteria) this;
        }

        public Criteria andTaxNumIsNotNull() {
            addCriterion("tax_num is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNumEqualTo(String value) {
            addCriterion("tax_num =", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotEqualTo(String value) {
            addCriterion("tax_num <>", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumGreaterThan(String value) {
            addCriterion("tax_num >", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("tax_num >=", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLessThan(String value) {
            addCriterion("tax_num <", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLessThanOrEqualTo(String value) {
            addCriterion("tax_num <=", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumLike(String value) {
            addCriterion("tax_num like", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotLike(String value) {
            addCriterion("tax_num not like", value, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumIn(List<String> values) {
            addCriterion("tax_num in", values, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotIn(List<String> values) {
            addCriterion("tax_num not in", values, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumBetween(String value1, String value2) {
            addCriterion("tax_num between", value1, value2, "taxNum");
            return (Criteria) this;
        }

        public Criteria andTaxNumNotBetween(String value1, String value2) {
            addCriterion("tax_num not between", value1, value2, "taxNum");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
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

        public Criteria andAddressAndPhoneNumIsNull() {
            addCriterion("address_and_phone_num is null");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumIsNotNull() {
            addCriterion("address_and_phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumEqualTo(String value) {
            addCriterion("address_and_phone_num =", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumNotEqualTo(String value) {
            addCriterion("address_and_phone_num <>", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumGreaterThan(String value) {
            addCriterion("address_and_phone_num >", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("address_and_phone_num >=", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumLessThan(String value) {
            addCriterion("address_and_phone_num <", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("address_and_phone_num <=", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumLike(String value) {
            addCriterion("address_and_phone_num like", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumNotLike(String value) {
            addCriterion("address_and_phone_num not like", value, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumIn(List<String> values) {
            addCriterion("address_and_phone_num in", values, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumNotIn(List<String> values) {
            addCriterion("address_and_phone_num not in", values, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumBetween(String value1, String value2) {
            addCriterion("address_and_phone_num between", value1, value2, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andAddressAndPhoneNumNotBetween(String value1, String value2) {
            addCriterion("address_and_phone_num not between", value1, value2, "addressAndPhoneNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumIsNull() {
            addCriterion("bank_and_num is null");
            return (Criteria) this;
        }

        public Criteria andBankAndNumIsNotNull() {
            addCriterion("bank_and_num is not null");
            return (Criteria) this;
        }

        public Criteria andBankAndNumEqualTo(String value) {
            addCriterion("bank_and_num =", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumNotEqualTo(String value) {
            addCriterion("bank_and_num <>", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumGreaterThan(String value) {
            addCriterion("bank_and_num >", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumGreaterThanOrEqualTo(String value) {
            addCriterion("bank_and_num >=", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumLessThan(String value) {
            addCriterion("bank_and_num <", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumLessThanOrEqualTo(String value) {
            addCriterion("bank_and_num <=", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumLike(String value) {
            addCriterion("bank_and_num like", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumNotLike(String value) {
            addCriterion("bank_and_num not like", value, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumIn(List<String> values) {
            addCriterion("bank_and_num in", values, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumNotIn(List<String> values) {
            addCriterion("bank_and_num not in", values, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumBetween(String value1, String value2) {
            addCriterion("bank_and_num between", value1, value2, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andBankAndNumNotBetween(String value1, String value2) {
            addCriterion("bank_and_num not between", value1, value2, "bankAndNum");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIsNull() {
            addCriterion("pdf_url is null");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIsNotNull() {
            addCriterion("pdf_url is not null");
            return (Criteria) this;
        }

        public Criteria andPdfUrlEqualTo(String value) {
            addCriterion("pdf_url =", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotEqualTo(String value) {
            addCriterion("pdf_url <>", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlGreaterThan(String value) {
            addCriterion("pdf_url >", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pdf_url >=", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLessThan(String value) {
            addCriterion("pdf_url <", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLessThanOrEqualTo(String value) {
            addCriterion("pdf_url <=", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlLike(String value) {
            addCriterion("pdf_url like", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotLike(String value) {
            addCriterion("pdf_url not like", value, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlIn(List<String> values) {
            addCriterion("pdf_url in", values, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotIn(List<String> values) {
            addCriterion("pdf_url not in", values, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlBetween(String value1, String value2) {
            addCriterion("pdf_url between", value1, value2, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andPdfUrlNotBetween(String value1, String value2) {
            addCriterion("pdf_url not between", value1, value2, "pdfUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlIsNull() {
            addCriterion("invoice_url is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlIsNotNull() {
            addCriterion("invoice_url is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlEqualTo(String value) {
            addCriterion("invoice_url =", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlNotEqualTo(String value) {
            addCriterion("invoice_url <>", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlGreaterThan(String value) {
            addCriterion("invoice_url >", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_url >=", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlLessThan(String value) {
            addCriterion("invoice_url <", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlLessThanOrEqualTo(String value) {
            addCriterion("invoice_url <=", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlLike(String value) {
            addCriterion("invoice_url like", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlNotLike(String value) {
            addCriterion("invoice_url not like", value, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlIn(List<String> values) {
            addCriterion("invoice_url in", values, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlNotIn(List<String> values) {
            addCriterion("invoice_url not in", values, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlBetween(String value1, String value2) {
            addCriterion("invoice_url between", value1, value2, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceUrlNotBetween(String value1, String value2) {
            addCriterion("invoice_url not between", value1, value2, "invoiceUrl");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIsNull() {
            addCriterion("invoice_num is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIsNotNull() {
            addCriterion("invoice_num is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumEqualTo(String value) {
            addCriterion("invoice_num =", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotEqualTo(String value) {
            addCriterion("invoice_num <>", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumGreaterThan(String value) {
            addCriterion("invoice_num >", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_num >=", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumLessThan(String value) {
            addCriterion("invoice_num <", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumLessThanOrEqualTo(String value) {
            addCriterion("invoice_num <=", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumLike(String value) {
            addCriterion("invoice_num like", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotLike(String value) {
            addCriterion("invoice_num not like", value, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumIn(List<String> values) {
            addCriterion("invoice_num in", values, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotIn(List<String> values) {
            addCriterion("invoice_num not in", values, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumBetween(String value1, String value2) {
            addCriterion("invoice_num between", value1, value2, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceNumNotBetween(String value1, String value2) {
            addCriterion("invoice_num not between", value1, value2, "invoiceNum");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIsNull() {
            addCriterion("invoice_code is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIsNotNull() {
            addCriterion("invoice_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeEqualTo(String value) {
            addCriterion("invoice_code =", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotEqualTo(String value) {
            addCriterion("invoice_code <>", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeGreaterThan(String value) {
            addCriterion("invoice_code >", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_code >=", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLessThan(String value) {
            addCriterion("invoice_code <", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLessThanOrEqualTo(String value) {
            addCriterion("invoice_code <=", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeLike(String value) {
            addCriterion("invoice_code like", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotLike(String value) {
            addCriterion("invoice_code not like", value, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeIn(List<String> values) {
            addCriterion("invoice_code in", values, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotIn(List<String> values) {
            addCriterion("invoice_code not in", values, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeBetween(String value1, String value2) {
            addCriterion("invoice_code between", value1, value2, "invoiceCode");
            return (Criteria) this;
        }

        public Criteria andInvoiceCodeNotBetween(String value1, String value2) {
            addCriterion("invoice_code not between", value1, value2, "invoiceCode");
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