package com.example.bookmall.entity;

import java.util.ArrayList;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        public Criteria andIidIsNull() {
            addCriterion("iid is null");
            return (Criteria) this;
        }

        public Criteria andIidIsNotNull() {
            addCriterion("iid is not null");
            return (Criteria) this;
        }

        public Criteria andIidEqualTo(Integer value) {
            addCriterion("iid =", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotEqualTo(Integer value) {
            addCriterion("iid <>", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThan(Integer value) {
            addCriterion("iid >", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThanOrEqualTo(Integer value) {
            addCriterion("iid >=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThan(Integer value) {
            addCriterion("iid <", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThanOrEqualTo(Integer value) {
            addCriterion("iid <=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidIn(List<Integer> values) {
            addCriterion("iid in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotIn(List<Integer> values) {
            addCriterion("iid not in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidBetween(Integer value1, Integer value2) {
            addCriterion("iid between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotBetween(Integer value1, Integer value2) {
            addCriterion("iid not between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andIusernameIsNull() {
            addCriterion("iusername is null");
            return (Criteria) this;
        }

        public Criteria andIusernameIsNotNull() {
            addCriterion("iusername is not null");
            return (Criteria) this;
        }

        public Criteria andIusernameEqualTo(String value) {
            addCriterion("iusername =", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameNotEqualTo(String value) {
            addCriterion("iusername <>", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameGreaterThan(String value) {
            addCriterion("iusername >", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameGreaterThanOrEqualTo(String value) {
            addCriterion("iusername >=", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameLessThan(String value) {
            addCriterion("iusername <", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameLessThanOrEqualTo(String value) {
            addCriterion("iusername <=", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameLike(String value) {
            addCriterion("iusername like", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameNotLike(String value) {
            addCriterion("iusername not like", value, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameIn(List<String> values) {
            addCriterion("iusername in", values, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameNotIn(List<String> values) {
            addCriterion("iusername not in", values, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameBetween(String value1, String value2) {
            addCriterion("iusername between", value1, value2, "iusername");
            return (Criteria) this;
        }

        public Criteria andIusernameNotBetween(String value1, String value2) {
            addCriterion("iusername not between", value1, value2, "iusername");
            return (Criteria) this;
        }

        public Criteria andIsexIsNull() {
            addCriterion("isex is null");
            return (Criteria) this;
        }

        public Criteria andIsexIsNotNull() {
            addCriterion("isex is not null");
            return (Criteria) this;
        }

        public Criteria andIsexEqualTo(String value) {
            addCriterion("isex =", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexNotEqualTo(String value) {
            addCriterion("isex <>", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexGreaterThan(String value) {
            addCriterion("isex >", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexGreaterThanOrEqualTo(String value) {
            addCriterion("isex >=", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexLessThan(String value) {
            addCriterion("isex <", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexLessThanOrEqualTo(String value) {
            addCriterion("isex <=", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexLike(String value) {
            addCriterion("isex like", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexNotLike(String value) {
            addCriterion("isex not like", value, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexIn(List<String> values) {
            addCriterion("isex in", values, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexNotIn(List<String> values) {
            addCriterion("isex not in", values, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexBetween(String value1, String value2) {
            addCriterion("isex between", value1, value2, "isex");
            return (Criteria) this;
        }

        public Criteria andIsexNotBetween(String value1, String value2) {
            addCriterion("isex not between", value1, value2, "isex");
            return (Criteria) this;
        }

        public Criteria andIageIsNull() {
            addCriterion("iage is null");
            return (Criteria) this;
        }

        public Criteria andIageIsNotNull() {
            addCriterion("iage is not null");
            return (Criteria) this;
        }

        public Criteria andIageEqualTo(Integer value) {
            addCriterion("iage =", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageNotEqualTo(Integer value) {
            addCriterion("iage <>", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageGreaterThan(Integer value) {
            addCriterion("iage >", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageGreaterThanOrEqualTo(Integer value) {
            addCriterion("iage >=", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageLessThan(Integer value) {
            addCriterion("iage <", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageLessThanOrEqualTo(Integer value) {
            addCriterion("iage <=", value, "iage");
            return (Criteria) this;
        }

        public Criteria andIageIn(List<Integer> values) {
            addCriterion("iage in", values, "iage");
            return (Criteria) this;
        }

        public Criteria andIageNotIn(List<Integer> values) {
            addCriterion("iage not in", values, "iage");
            return (Criteria) this;
        }

        public Criteria andIageBetween(Integer value1, Integer value2) {
            addCriterion("iage between", value1, value2, "iage");
            return (Criteria) this;
        }

        public Criteria andIageNotBetween(Integer value1, Integer value2) {
            addCriterion("iage not between", value1, value2, "iage");
            return (Criteria) this;
        }

        public Criteria andIphoneIsNull() {
            addCriterion("iphone is null");
            return (Criteria) this;
        }

        public Criteria andIphoneIsNotNull() {
            addCriterion("iphone is not null");
            return (Criteria) this;
        }

        public Criteria andIphoneEqualTo(Integer value) {
            addCriterion("iphone =", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneNotEqualTo(Integer value) {
            addCriterion("iphone <>", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneGreaterThan(Integer value) {
            addCriterion("iphone >", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("iphone >=", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneLessThan(Integer value) {
            addCriterion("iphone <", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneLessThanOrEqualTo(Integer value) {
            addCriterion("iphone <=", value, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneIn(List<Integer> values) {
            addCriterion("iphone in", values, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneNotIn(List<Integer> values) {
            addCriterion("iphone not in", values, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneBetween(Integer value1, Integer value2) {
            addCriterion("iphone between", value1, value2, "iphone");
            return (Criteria) this;
        }

        public Criteria andIphoneNotBetween(Integer value1, Integer value2) {
            addCriterion("iphone not between", value1, value2, "iphone");
            return (Criteria) this;
        }

        public Criteria andIrealnameIsNull() {
            addCriterion("irealname is null");
            return (Criteria) this;
        }

        public Criteria andIrealnameIsNotNull() {
            addCriterion("irealname is not null");
            return (Criteria) this;
        }

        public Criteria andIrealnameEqualTo(String value) {
            addCriterion("irealname =", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameNotEqualTo(String value) {
            addCriterion("irealname <>", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameGreaterThan(String value) {
            addCriterion("irealname >", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameGreaterThanOrEqualTo(String value) {
            addCriterion("irealname >=", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameLessThan(String value) {
            addCriterion("irealname <", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameLessThanOrEqualTo(String value) {
            addCriterion("irealname <=", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameLike(String value) {
            addCriterion("irealname like", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameNotLike(String value) {
            addCriterion("irealname not like", value, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameIn(List<String> values) {
            addCriterion("irealname in", values, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameNotIn(List<String> values) {
            addCriterion("irealname not in", values, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameBetween(String value1, String value2) {
            addCriterion("irealname between", value1, value2, "irealname");
            return (Criteria) this;
        }

        public Criteria andIrealnameNotBetween(String value1, String value2) {
            addCriterion("irealname not between", value1, value2, "irealname");
            return (Criteria) this;
        }

        public Criteria andIaddressIsNull() {
            addCriterion("iaddress is null");
            return (Criteria) this;
        }

        public Criteria andIaddressIsNotNull() {
            addCriterion("iaddress is not null");
            return (Criteria) this;
        }

        public Criteria andIaddressEqualTo(String value) {
            addCriterion("iaddress =", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressNotEqualTo(String value) {
            addCriterion("iaddress <>", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressGreaterThan(String value) {
            addCriterion("iaddress >", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressGreaterThanOrEqualTo(String value) {
            addCriterion("iaddress >=", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressLessThan(String value) {
            addCriterion("iaddress <", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressLessThanOrEqualTo(String value) {
            addCriterion("iaddress <=", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressLike(String value) {
            addCriterion("iaddress like", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressNotLike(String value) {
            addCriterion("iaddress not like", value, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressIn(List<String> values) {
            addCriterion("iaddress in", values, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressNotIn(List<String> values) {
            addCriterion("iaddress not in", values, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressBetween(String value1, String value2) {
            addCriterion("iaddress between", value1, value2, "iaddress");
            return (Criteria) this;
        }

        public Criteria andIaddressNotBetween(String value1, String value2) {
            addCriterion("iaddress not between", value1, value2, "iaddress");
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