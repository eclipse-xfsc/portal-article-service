package tsystems.gaiax.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tsystems.gaiax.article.dto.ArticleDetails;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class ArticleService {

    @Autowired
    private RestTemplate http;
    @Value("${services.articles.uri.internal}")
    private String identitySystemHost;


    public List<ArticleDetails> getArticlesByCategory(String category) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(identitySystemHost + "/articles/filter")
                .queryParam("category", "{category}")
                .encode()
                .toUriString();
        Map<String, String> params = new HashMap<>();
        params.put("category", category);
        HttpEntity<ArticleDetails[]> response = http.exchange(
                urlTemplate,
                HttpMethod.GET,
                entity,
                ArticleDetails[].class,
                params
        );
        if (response.getBody() == null) return Collections.emptyList();
        return Arrays.asList(response.getBody());
    }
}


