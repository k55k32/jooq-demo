package diamond.jooq.demo;

import java.util.UUID;

import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import diamond.jooq.demo.model.jooq.Tables;
import diamond.jooq.demo.model.jooq.tables.pojos.UserPojo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@Rollback
@Transactional
public class JooqDemoTest {
    @Autowired
    DSLContext context;

    @Test
    public void insertUserTest(){
        UserPojo user = new UserPojo();
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        user.setUsername("test user");
        user.setPassword("test password");
        user.setEmail("emailtest@test.com");
        context.newRecord(Tables.USER, user).store();
        UserPojo saveUser = context.select().from(Tables.USER).where(Tables.USER.ID.eq(userId)).fetchOneInto(UserPojo.class);
        Assert.assertTrue(saveUser.getId().equals(user.getId()));
    }
}
