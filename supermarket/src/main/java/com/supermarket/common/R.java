package com.supermarket.common;

import lombok.Data;

import java.util.HashMap;

import java.util.Map;

    @Data
    public class R {
        private Integer code;   // 响应的状态码

        private String message;  // 响应的信息

        private Boolean success;  // 是否成功

        private Map<Object,Object> data = new HashMap<>();  // 封装响应的数据

        private R() {
        }

        // 返回成功的结果
        public static com.supermarket.common.R ok(){
            com.supermarket.common.R r = new com.supermarket.common.R();
            r.setSuccess(true);
            r.setCode(20000);
            r.setMessage("success");
            return r;
        }

        // 返回失败的结果
        public static com.supermarket.common.R error(){
            com.supermarket.common.R r = new com.supermarket.common.R();
            r.setSuccess(false);
            r.setCode(4444);
            r.setMessage("fail");
            return r;
        }

        //单独设置 响应成功还是失败
        public com.supermarket.common.R success(Boolean success){
            this.setSuccess(success);
            return this;
        }

        //单独设置 响应信息
        public com.supermarket.common.R message(String message){
            this.setMessage(message);
            return this;
        }

        //单独设置 响应状态码
        public com.supermarket.common.R code(Integer code){
            this.setCode(code);
            return this;
        }

        // 封装数据  封装一个 键值
        public com.supermarket.common.R data(Object key, Object value){
            this.data.put(key,value);
            return this;
        }

        //封装一个 map
        public com.supermarket.common.R data(Map<Object,Object> map){
            this.setData(map);
            return this;
        }
    }


