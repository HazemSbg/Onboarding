package Tivoli.Onboarding.newhire;

import java.util.List;

public interface NewHireService {

    NewHires create(NewHires newHire);

    NewHires getByCode(Integer code);

    List<NewHires> getAll();

    NewHires update(Integer code, NewHires newHire);

    void delete(Integer code);
}
