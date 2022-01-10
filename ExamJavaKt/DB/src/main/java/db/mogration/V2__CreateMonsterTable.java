package db.mogration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V2__CreateMonsterTable extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("create table monster\n" +
                        "(\n" +
                        "    id   serial primary key,\n" +
                        "    name varchar not null unique,\n" +
                        "    hit_point varchar,\n"+
                        "    attack_modifier varchar,\n"+
                        "    attack_Per_Round varchar,\n"+
                        "    damage varchar(3),\n"+
                        "    damage_mod varchar,\n"+
                        "    armor varchar\n"+
                        ")");
    }
}
