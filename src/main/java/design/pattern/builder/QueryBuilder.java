package design.pattern.builder;

public class QueryBuilder {

    private StringBuilder baseQuery;
    private StringBuilder whereClause;
    private StringBuilder orderByClause;

    public QueryBuilder(String baseQuery) {
        this.baseQuery = new StringBuilder(baseQuery);
        this.whereClause = new StringBuilder();
        this.orderByClause = new StringBuilder();
    }

    public QueryBuilder addFilter(String column, String operator, String value) {
        if (whereClause.length() == 0) {
            whereClause.append(" WHERE ");
        } else {
            whereClause.append(" AND ");
        }
        whereClause.append(column).append(" ").append(operator).append(" '").append(value).append("'");
        return this;
    }

    public QueryBuilder addOrderBy(String column, String direction) {
        if (orderByClause.length() == 0) {
            orderByClause.append(" ORDER BY ");
        } else {
            orderByClause.append(", ");
        }
        orderByClause.append(column).append(" ").append(direction);
        return this;
    }

    public String build() {
        return baseQuery.toString() + whereClause.toString() + orderByClause.toString();
    }
}
