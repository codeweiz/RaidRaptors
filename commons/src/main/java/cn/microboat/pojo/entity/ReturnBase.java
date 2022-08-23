package cn.microboat.pojo.entity;

import cn.microboat.pojo.entity.exception.Error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用返回封装
 *
 * @author zhouwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBase<T> {

    private Boolean success;
    private T data;
    private Error error;
    private Integer dataLength;

    /**
     * 设置数据，返回成功
     *
     * @param data 数据
     * @return <T>ReturnBase<T>
     */
    public static <T> ReturnBase<T> ok(T data) {
        ReturnBase<T> returnBase = new ReturnBase<>();
        returnBase.setSuccess(true);
        returnBase.setData(data);
        returnBase.setError(null);
        returnBase.setDataLength(null);
        if (data instanceof List) {
            returnBase.setDataLength(((List<?>) data).size());
        }
        return returnBase;
    }

    /**
     * 设置Error，返回失败
     *
     * @param error Error
     * @return <T>ReturnBase<T>
     */
    public static <T> ReturnBase<T> error(Error error) {
        ReturnBase<T> returnBase = new ReturnBase<>();
        returnBase.setSuccess(false);
        returnBase.setData(null);
        returnBase.setError(error);
        returnBase.setDataLength(null);
        return returnBase;
    }

    /**
     * 设置 数据 和 Error，返回失败
     *
     * @param error Error
     * @param data  数据
     * @return <T>ReturnBase<T>
     */
    public static <T> ReturnBase<T> error(T data, Error error) {
        ReturnBase<T> returnBase = new ReturnBase<>();
        returnBase.setSuccess(false);
        returnBase.setData(data);
        returnBase.setError(error);
        returnBase.setDataLength(null);
        if (data instanceof List) {
            returnBase.setDataLength(((List<?>) data).size());
        }
        return returnBase;
    }
}
