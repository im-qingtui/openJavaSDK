package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.collections.CollectionUtils;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewsMsg extends BaseBean implements Serializable {

    private List<Article> articles;

    public Article getCover() {
        if (CollectionUtils.isEmpty(articles)) {
            return null;
        }

        for (Article art : articles) {
            if (art.getShowCoverPic() == 1) {
                return art;
            }
        }

        return articles.get(0);
    }

    public void setCover(Article cover) {
    }

}
