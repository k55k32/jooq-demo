/**
 * This class is generated by jOOQ
 */
package diamond.jooq.demo.model.jooq.tables.interfaces;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IArticle extends Serializable {

    /**
     * Setter for <code>jooq-demo.article.id</code>.
     */
    public void setId(String value);

    /**
     * Getter for <code>jooq-demo.article.id</code>.
     */
    public String getId();

    /**
     * Setter for <code>jooq-demo.article.user_id</code>.
     */
    public void setUserId(String value);

    /**
     * Getter for <code>jooq-demo.article.user_id</code>.
     */
    public String getUserId();

    /**
     * Setter for <code>jooq-demo.article.title</code>.
     */
    public void setTitle(String value);

    /**
     * Getter for <code>jooq-demo.article.title</code>.
     */
    public String getTitle();

    /**
     * Setter for <code>jooq-demo.article.content</code>.
     */
    public void setContent(String value);

    /**
     * Getter for <code>jooq-demo.article.content</code>.
     */
    public String getContent();

    /**
     * Setter for <code>jooq-demo.article.create_time</code>.
     */
    public void setCreateTime(Timestamp value);

    /**
     * Getter for <code>jooq-demo.article.create_time</code>.
     */
    public Timestamp getCreateTime();

    /**
     * Setter for <code>jooq-demo.article.update_time</code>.
     */
    public void setUpdateTime(Timestamp value);

    /**
     * Getter for <code>jooq-demo.article.update_time</code>.
     */
    public Timestamp getUpdateTime();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IArticle
     */
    public void from(diamond.jooq.demo.model.jooq.tables.interfaces.IArticle from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IArticle
     */
    public <E extends diamond.jooq.demo.model.jooq.tables.interfaces.IArticle> E into(E into);
}
