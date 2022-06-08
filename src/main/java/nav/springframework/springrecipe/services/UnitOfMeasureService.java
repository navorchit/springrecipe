package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUnitsOfMeasure();

}
