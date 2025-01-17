package com.ghostdovahkiin.book_category.category;

import com.ghostdovahkiin.book_category.category.services.SaveCategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ghostdovahkiin.book_category.category.builder.CategoryBuilder.createCategory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests execution for Save Category Service")
class SaveCategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    private SaveCategoryServiceImpl saveCategoryService;

    @BeforeEach
    void SetUp() {
        this.saveCategoryService = new SaveCategoryServiceImpl(categoryRepository);
    }

    @Test
    @DisplayName("Should save a category")
    void shouldSaveCategory() {
        saveCategoryService.save(createCategory().build());

        ArgumentCaptor<Category> captorCategory = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository, times(1)).save(captorCategory.capture());

        Category resultCategory = captorCategory.getValue();

        assertAll("Category",
                () -> assertThat(resultCategory.getName(), is("Mathematics"))
        );
    }
}
