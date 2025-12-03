package Tivoli.Onboarding.newHires;

import java.util.List;

public interface NewHiresService {

    // Create
    NewHires createNewHires(NewHires newHires);

    // Update
    NewHires updateNewHires(Integer code, NewHires newHires);

    // Delete
    void deleteNewHires(Integer code);

    // Get
    NewHires getNewHires(Integer code);

    // Get all
    List<NewHires> getAllNewHires();

    NewHires save(NewHires saved);
}
