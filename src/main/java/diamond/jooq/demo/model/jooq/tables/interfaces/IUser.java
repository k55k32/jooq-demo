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
public interface IUser extends Serializable {

    /**
     * Setter for <code>jooq-demo.user.id</code>.
     */
    public void setId(String value);

    /**
     * Getter for <code>jooq-demo.user.id</code>.
     */
    public String getId();

    /**
     * Setter for <code>jooq-demo.user.username</code>.
     */
    public void setUsername(String value);

    /**
     * Getter for <code>jooq-demo.user.username</code>.
     */
    public String getUsername();

    /**
     * Setter for <code>jooq-demo.user.password</code>.
     */
    public void setPassword(String value);

    /**
     * Getter for <code>jooq-demo.user.password</code>.
     */
    public String getPassword();

    /**
     * Setter for <code>jooq-demo.user.nickname</code>.
     */
    public void setNickname(String value);

    /**
     * Getter for <code>jooq-demo.user.nickname</code>.
     */
    public String getNickname();

    /**
     * Setter for <code>jooq-demo.user.email</code>.
     */
    public void setEmail(String value);

    /**
     * Getter for <code>jooq-demo.user.email</code>.
     */
    public String getEmail();

    /**
     * Setter for <code>jooq-demo.user.birthday</code>.
     */
    public void setBirthday(Timestamp value);

    /**
     * Getter for <code>jooq-demo.user.birthday</code>.
     */
    public Timestamp getBirthday();

    /**
     * Setter for <code>jooq-demo.user.create_time</code>.
     */
    public void setCreateTime(Timestamp value);

    /**
     * Getter for <code>jooq-demo.user.create_time</code>.
     */
    public Timestamp getCreateTime();

    /**
     * Setter for <code>jooq-demo.user.login_time</code>.
     */
    public void setLoginTime(Timestamp value);

    /**
     * Getter for <code>jooq-demo.user.login_time</code>.
     */
    public Timestamp getLoginTime();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IUser
     */
    public void from(diamond.jooq.demo.model.jooq.tables.interfaces.IUser from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IUser
     */
    public <E extends diamond.jooq.demo.model.jooq.tables.interfaces.IUser> E into(E into);
}