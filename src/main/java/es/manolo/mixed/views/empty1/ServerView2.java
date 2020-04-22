package es.manolo.mixed.views.empty1;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.manolo.mixed.views.empty.ServerView1;


@Route(value = "2")
@PageTitle("Empty1")
@CssImport("views/empty1/empty1-view.css")
public class ServerView2 extends Div implements BeforeLeaveObserver {

    public ServerView2() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        setId("empty1-view");
        add(new Label("Server View2"));

//        add(new RouterLink("Server View1 routerlink", ServerView2.class));
        add(new Button("Server View1", buttonClickEvent -> {
            final UI ui = buttonClickEvent.getSource().getUI().get();

            ui.navigate(ServerView1.class);

//            History history = new History(ui);
//            history.pushState(null, "1");
        }));

    }

    @Override
    public void beforeLeave(BeforeLeaveEvent beforeLeaveEvent) {
        beforeLeaveEvent.postpone();

        Button okButton = new Button("Yes");
        Button cancelButton = new Button("No");
        Dialog dialog = new Dialog(new Label("Close this?"), okButton, cancelButton);
        okButton.addClickListener(buttonClickEvent -> {
            dialog.close();
            beforeLeaveEvent.getContinueNavigationAction().proceed();
        });
        cancelButton.addClickListener(buttonClickEvent -> {
            dialog.close();
        });

        dialog.open();
    }

}
