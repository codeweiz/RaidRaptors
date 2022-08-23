package cn.microboat.pojo.entity.exception;

/**
 * @author zhouwei
 */

public enum BizCodeEnum {
    /**
     * 系统未知异常
     * */
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),

    /**
     * 参数格式校验失败
     * */
    VALID_EXCEPTION(10001, "参数格式校验失败");

    private final int code;
    private final String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
