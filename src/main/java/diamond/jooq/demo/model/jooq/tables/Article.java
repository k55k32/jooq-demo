/**
 * This class is generated by jOOQ
 */
package diamond.jooq.demo.model.jooq.tables;


import diamond.jooq.demo.model.jooq.JooqDemo;
import diamond.jooq.demo.model.jooq.Keys;
import diamond.jooq.demo.model.jooq.tables.records.ArticleRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = -1358634237;

    /**
     * The reference instance of <code>jooq-demo.article</code>
     */
    public static final Article ARTICLE = new Article();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>jooq-demo.article.id</code>.
     */
    public final TableField<ArticleRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(40).nullable(false), this, "");

    /**
     * The column <code>jooq-demo.article.user_id</code>.
     */
    public final TableField<ArticleRecord, String> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.VARCHAR.length(40).nullable(false), this, "");

    /**
     * The column <code>jooq-demo.article.title</code>.
     */
    public final TableField<ArticleRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

    /**
     * The column <code>jooq-demo.article.content</code>.
     */
    public final TableField<ArticleRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>jooq-demo.article.create_time</code>.
     */
    public final TableField<ArticleRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>jooq-demo.article.update_time</code>.
     */
    public final TableField<ArticleRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>jooq-demo.article</code> table reference
     */
    public Article() {
        this("article", null);
    }

    /**
     * Create an aliased <code>jooq-demo.article</code> table reference
     */
    public Article(String alias) {
        this(alias, ARTICLE);
    }

    private Article(String alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Article(String alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JooqDemo.JOOQ_DEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.KEY_ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(String alias) {
        return new Article(alias, this);
    }

    /**
     * Rename this table
     */
    public Article rename(String name) {
        return new Article(name, null);
    }
}