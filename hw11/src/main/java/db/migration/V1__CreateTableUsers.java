package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V1__CreateTableUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("create table users\n" +
                        "(\n" +
                        "    id        serial primary key unique,\n" +
                        "    username  varchar not null unique,\n" +
                        "    password  varchar not null,\n" +
                        "    firstname varchar not null,\n" +
                        "    lastname  varchar not null,\n" +
                        "    enabled boolean not null default true\n" +
                        ")");
    }

}