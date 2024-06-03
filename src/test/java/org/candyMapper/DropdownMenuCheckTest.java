package org.candyMapper;

import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.MainScreenSteps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownMenuCheckTest extends BaseTest {

    private final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();

    @Test
    public void checkIfSpecificCountyExist() {
        mainScreenPopupSteps.closePopup();
        List<WebElement> dropdownList = mainScreenSteps.getDropdownList();
        mainScreenSteps.checkCountyNamesAndDuplicationsInDropdownList(dropdownList);
    }
}
