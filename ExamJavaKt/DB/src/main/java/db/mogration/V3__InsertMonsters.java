package db.mogration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V3__InsertMonsters extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("insert into monster(name, hit_point, attack_modifier, attack_per_round, damage, damage_mod, armor) values('Dolphin', 11, 4, 1, '1d6', 3, 12);\n" +
                                "insert into monster(name, hit_point, attack_modifier, attack_per_round, damage, damage_mod, armor) values('Dragon turtle', 341, 13, 2, '2d8', 16, 20);\n" +
                                "insert into monster(name, hit_point, attack_modifier, attack_per_round, damage, damage_mod, armor) values('Ice toad', 32, 3, 1, '1d8', 1, 12);\n"
                        );

    }
}
