package diamond.jooq.demo.model;

import diamond.jooq.demo.model.jooq.tables.pojos.ArticlePojo;

public class Article extends ArticlePojo{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String username;
    public String nickname;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
