package tsystems.gaiax.article.utils;

import java.util.stream.Stream;

/**
 * ...
 */
public enum ArticleCategory {
    NEWS,
    ARTICLE;

    /**
     * Check if incoming category is valid.
     *
     * @param category ...
     * @return ...
     */
    public static boolean contains(String category) {
        return Stream.of(ArticleCategory.values())
                .anyMatch(x -> x.name().equalsIgnoreCase(category));
    }
}
