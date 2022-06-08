package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.UnitOfMeasureCommand;
import nav.springframework.springrecipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import nav.springframework.springrecipe.model.UnitOfMeasure;
import nav.springframework.springrecipe.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UnitOfMeasureServiceImplTest {

    @Spy
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @InjectMocks
    UnitOfMeasureServiceImpl unitOfMeasureService;

    @Test
    void listAllUnitsOfMeasure() {
        Set<UnitOfMeasure> unitsOfMeasure = new HashSet<>();
        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setId(1L);
        unitsOfMeasure.add(unitOfMeasure1);
        UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
        unitOfMeasure2.setId(2L);
        unitsOfMeasure.add(unitOfMeasure2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitsOfMeasure);

        Set<UnitOfMeasureCommand> commands = unitOfMeasureService.listAllUnitsOfMeasure();

        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }
}