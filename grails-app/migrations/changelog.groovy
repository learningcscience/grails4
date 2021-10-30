databaseChangeLog = {

    changeSet(author: "user (generated)", id: "1635571597464-1") {
        createTable(tableName: "book") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "bookPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "title", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "author", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }
}
