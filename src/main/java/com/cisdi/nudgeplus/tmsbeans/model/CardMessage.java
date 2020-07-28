package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import im.qingtui.cross.card_message.Card;
import im.qingtui.cross.card_message.CardExtensionKt;
import im.qingtui.cross.card_message.TestKt;
import java.io.Serializable;

/**
 * 卡片消息
 *
 * @author leesir
 */
public class CardMessage implements Message {

    private Card card;

    private String content;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getContent() {
        return CardExtensionKt.getSerializer().toSerialized(card);
    }

    public void setContent(String content) {
        this.content = content;
    }
}
