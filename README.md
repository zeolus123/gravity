
# gravity



You work for an educational software company that is developing a suite of simple
Physics simulations. The code in **gravity** *github repository* is the beginning of a suite intended to permit the creation of a series of different types of pendulum simulation. You previously identified the ***AbstractEarthPendulum*** class as trivial and unnecessary, but
figured it was mostly harmless. Now your team wants to be able to dynamically set which
planet a pendulum is on during an interactive simulation, and to allow different kinds of
gravity models that are impossible to represent with a single constant (e.g., latitude
models).

***Fork*** the gravity repository (https://github.com/ashrafcourses/gravity) to your own github account.
1. Run the main routine to see the expected behavior of the code.
2. Apply the refactoring approach "*Collapse Hierarchy*" to reduce the hierarchy levels by
one. Ensure that the main routine still works as expected. Push your refactored code to the remote branch "RefactoringStep1".
3. Use the **Strategy** pattern to replace the field *g* with a reference to a strategy object. This should allow different kinds of gravity models to be associated with a
Pendulum instance dynamically. Name the strategy interface **GravityModel**.
``` java
public interface GravityModel{
      public double getGravitationalField();
}
```
Objects implementing GravityModel will be initialized with all state
required to produce the gravitational field value under their specific model, this
occurs before being assigned to a pendulum. The pendulums will just use
the model assigned to it via the GravityModel interface. Adjust the pendulum constructors so that a **GravityModel** is assigned on initialization, and add a new
method that will allow the GravityModel to be changed dynamically.
Define one concrete strategy called **GravityConstant**. This class simply receives a
constant value for *g* in its constructor.
4. Run the main routine to ensure that the functionality hasn’t changed. Push your refactored code to the remote branch "RefactoringStep2".
5. Modify the provided main routine as follows:
  * it initializes a **SimplePendulum** and a **RegularPendulum** with a **GravityConstant** object.
  * let the pendulums swing for a little while, then assign a different **GravityConstant** object. For example, your first **GravityConstant** could represent the Earth’s gravitational field (9.81 m/s^2), and the second could represent Jupiter’s (25 m/s^2). Push your code to the remote branch "RefactoringStep3".
