package tsystems.gaiax.article.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"test"})
public class ArticleRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleRest rest;

    @Test
    void filterArticlesByCategory() throws Exception {
        ResponseEntity rs = ResponseEntity.ok().build();
        when(rest.filterArticlesByCategory(any())).thenReturn(rs);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/filter?category=ARTICLE"))
                .andExpect(status().isOk());
    }
}
