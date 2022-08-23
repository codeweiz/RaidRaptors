package cn.microboat.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;

/**
 * @author zhouwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private Session session;
}
