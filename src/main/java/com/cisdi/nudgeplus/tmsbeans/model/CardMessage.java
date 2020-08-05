package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import im.qingtui.cross.card_message.Card;
import lombok.Data;

/**
 * 卡片消息
 *
 * @author leesir
 */
@Data
public class CardMessage implements Message {

    private Card card;

    private String content;

}
