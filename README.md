# Java-unit-tests

Úlohou cviceni je napisat unit testy na kod, 
ktory sa nachadza v baliku src/main/java/com/example/demo/widget 
V tomto balíku je jednoducha webova aplikacia, 
ktora umoznuje vytvoriť, editovat, precitat alebo vymazať widgety. 
Widgety su ulozene v DB, k tym sa pristupuje pomocou triedy WidgetRepository 
a logika je umiestnená v triede WidgetService.
![Image of widget arch](https://images.idgesg.net/images/article/2020/05/jw-osjp-junit5tutorial-p2fig1-100841694-large.jpg?auto=webp)

## How to run tests
Testy je mozne spustit priamo cez intellij.
Na lavo od nazvu konkretneho testu alebo testovacej triedy je zelena sipka.
Po kliknuti na nu je mozne spustit konkretny test alebo
v pripade nazvu danej triedy je mozne spustit vsetky testy v konkretnej triedy.

## How to run tests with coverage

Taktiez je možné spustit testy spolu s coverage.
Ten nam na pravej strane zobrazi nazov pokrytej triedy spolu s %,
kolko tried, metod a riadkov kodu je pokrytich vykonanymi testami.
Po dvojkliku v pravo na triedu sa otvori v novom tabe a kazdy riadok kodu ma
naľavo bud zelenu (je otestovany) alebo cervenu farbu (nie je otestovany).



## Repository tests
Ulohou je doplnit chybajuce testy do test triedy v src/test/java/com/example/demo/widget/repository/WidgetRepositoryTest.java.
Testy su oznacene anotaciou @Test a mockovane data, ktore pouzivaju su nastavene pomocou anotacie @DataSet("widgets.yml") v subore src/test/resources/datasets/widgets.yml
```sh
widget:
- id: 1
  name: "Widget 1"
  description: "This is widget 1"
  version: 1
- id: 2
  name: "Widget 2"
  description: "This is widget 2"
  version: 7
```
V jednotlivych testoch sa volaju metody z WidgetRepository triedy: repository.findAll() a pomocou assert funckcii z Assertions triedy
sa testuju vratene hodnoty: 
```sh
Assertions.assertEquals(2, widgets.size(), "Expected 2 widgets in the database");
```
Podobne doplnte ostatne prazde testovacie metody.

## Service tests

Testy na WidgetService je potrebne doplnit to triedy src/test/java/com/example/demo/widget/service/WidgetServiceTest.java
Tato trieda obsahuje mock WidgetRepository, ktorej metody je mozne namockovat pomocou prikazu: 
```sh
Widget widget = new Widget(1l, "Widget Name", "Description", 1);
doReturn(Optional.of(widget)).when(repository).findById(1l);
```
Nasledne sa zavola metoda, ktoru ideme testovat
```sh
Optional<Widget> returnedWidget = service.findById(1l);
```
a zase pomocou Assertions.assert* metod, skontrolujeme vysledok

```sh
Assertions.assertTrue(returnedWidget.isPresent(), "Widget was found");
Assertions.assertSame(returnedWidget.get(), widget, "The widget returned was the same as the mock");
```

Podobne doplnte ostatne prazde testovacie metody vo WidgetServiceTest.java triede.

## Controller tests
Controller testy sa nachadzaju v triede WidgetRestControllerTest.java a testuju API definovane vo WidgetRestController triede.
Pomocou triedy MockMvc je mozne vykonat request (get,post,put,delete) a otestovat funcionality daneho endpointu.

priklad: https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/

Ako prve je potrebne namockovat data pomocou doReturn metody

```sh
Widget widget1 = new Widget(1l, "Widget Name", "Description", 1);
Widget widget2 = new Widget(2l, "Widget 2 Name", "Description 2", 4);
doReturn(Lists.newArrayList(widget1, widget2)).when(service).findAll();
```

a potom pomocou mockmvc vykonat call na dany endpoint a otestovat, ci nam to vratil spravne hodnoty pomocou .andExpect metody
```sh
mockMvc.perform(get("/rest/widgets"))
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON))
.andExpect(jsonPath("$", hasSize(2)))
.andExpect(jsonPath("$[0].id", is(1)))
.andExpect(jsonPath("$[0].name", is("Widget Name")))
.andExpect(jsonPath("$[0].description", is("Description")))
.andExpect(jsonPath("$[0].version", is(1)))
.andExpect(jsonPath("$[1].id", is(2)))
.andExpect(jsonPath("$[1].name", is("Widget 2 Name")))
.andExpect(jsonPath("$[1].description", is("Description 2")))
.andExpect(jsonPath("$[1].version", is(4)));
```
