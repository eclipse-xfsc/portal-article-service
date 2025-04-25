package tsystems.gaiax.article.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tsystems.gaiax.article.dto.ArticleDetails;
import tsystems.gaiax.article.service.ArticleService;
import tsystems.gaiax.article.utils.ArticleCategory;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Api(tags = "Article Service")
public class ArticleRest {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/filter")
    @ApiOperation("Get articles by category")
    public ResponseEntity<List<ArticleDetails>> filterArticlesByCategory(@RequestParam("category") String category) {
        if (!ArticleCategory.contains(category)) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(Collections.emptyList());
        }
        List<ArticleDetails> articlesByCategory = articleService.getArticlesByCategory(category);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articlesByCategory);
    }
}
