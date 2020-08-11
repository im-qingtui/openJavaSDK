package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import im.qingtui.cross.card_message.Card;
import im.qingtui.cross.card_message.CardExtensionKt;
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

    public String getContent() {
        return CardExtensionKt.getSerializer().toSerialized(card);
    }

    public void setContent(String content) {
        this.content = content;
    }

}
