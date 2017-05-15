package diamond.jooq.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import diamond.jooq.demo.model.jooq.Tables;
import diamond.jooq.demo.model.jooq.tables.Article;
import diamond.jooq.demo.model.jooq.tables.User;
import diamond.jooq.demo.model.jooq.tables.pojos.ArticlePojo;
import diamond.jooq.demo.model.jooq.tables.pojos.UserPojo;
import diamond.jooq.demo.model.jooq.tables.records.ArticleRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@Rollback
@Transactional
public class JooqDemoTest {
    @Autowired
    DSLContext context;

    @Test
    public void insertUserTest(){
        saveUser();
    }

    public UserPojo saveUser(){
        UserPojo user = new UserPojo();
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        user.setUsername("test user");
        user.setPassword("test password");
        user.setEmail("emailtest@test.com");
        context.newRecord(Tables.USER, user).store();
        UserPojo saveUser = context.select().from(Tables.USER).where(Tables.USER.ID.eq(userId)).fetchOneInto(UserPojo.class);
        Assert.assertTrue(saveUser.getId().equals(user.getId()));
        return user;
    }

    public ArticlePojo saveArticle(){
        UserPojo user = saveUser();
        ArticlePojo article = new ArticlePojo();
        article.setUserId(user.getId());
        String articleId = UUID.randomUUID().toString();
        article.setId(articleId);
        article.setTitle("test title");
        article.setContent("test article content");
        context.newRecord(Tables.ARTICLE, article).store();
        ArticlePojo saveArticle = context.select().from(Tables.ARTICLE).where(Tables.ARTICLE.ID.eq(articleId)).fetchOneInto(ArticlePojo.class);
        Assert.assertTrue(saveArticle.getId().equals(articleId));
        return article;
    }

    @Test
    public void selectArticleTest() {
        saveArticle();
    }

    @Test
    public void updateArticleTest() {
        ArticlePojo article = saveArticle();
        ArticleRecord record = context.newRecord(Tables.ARTICLE, article);
        String updateTitle = "test-2";
        record.setTitle(updateTitle);
        record.update();
        ArticlePojo updateArticle = context.select().from(Tables.ARTICLE).where(Tables.ARTICLE.ID.eq(record.getId())).fetchOneInto(ArticlePojo.class);
        updateArticle.getTitle().equals(updateTitle);
        Assert.assertEquals(updateArticle.getTitle(), updateTitle);
    }

    @Test
    public void joinSelectArticleUser(){
        UserPojo user = saveUser();
        ArticlePojo article = new ArticlePojo();
        article.setUserId(user.getId());
        String articleId = UUID.randomUUID().toString();
        article.setId(articleId);
        article.setTitle("test title");
        article.setContent("test article content");
        context.newRecord(Tables.ARTICLE, article).store();
        Article articleTable = Tables.ARTICLE;
        User userTable = Tables.USER;
        List<Field<?>> fields = new ArrayList<>();
        fields.addAll(Arrays.asList(articleTable.fields()));
        fields.addAll(Arrays.asList(userTable.fields()));
        diamond.jooq.demo.model.Article joinArticle = context.select(fields).from(articleTable.leftJoin(userTable).on(articleTable.USER_ID.eq(userTable.ID)))
        .where(articleTable.ID.eq(article.getId())).fetchOne(r -> {
            diamond.jooq.demo.model.Article articleModel = r.into(diamond.jooq.demo.model.Article.class);
            articleModel.setUsername(r.get(userTable.USERNAME));
            articleModel.setNickname(r.get(userTable.NICKNAME));
            return articleModel;
        });
        Assert.assertEquals(joinArticle.getUsername(), user.getUsername());
        Assert.assertEquals(joinArticle.getNickname(), user.getNickname());
    }
}
