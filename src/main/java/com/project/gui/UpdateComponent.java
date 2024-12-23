package com.project.gui;

import com.almasb.fxgl.entity.component.Component;
import com.project.data.ThreadTracker;

public class UpdateComponent extends Component {
    public Runnable update;
    public UpdateComponent(Runnable update) {
        this.update = update;
    }
    @Override
    public void onUpdate(double tpf) {
        update.run();
    }
}
