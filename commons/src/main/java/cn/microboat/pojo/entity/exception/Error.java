package cn.microboat.pojo.entity.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

    private int errorCode;
    private String errorMsg;
}
