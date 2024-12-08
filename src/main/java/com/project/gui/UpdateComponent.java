package com.project.gui;

import com.almasb.fxgl.entity.component.Component;
import com.project.data.ThreadTracker;

public class UpdateComponent extends Component {
    ThreadTracker tracker;
    public UpdateComponent (ThreadTracker tracker){
        this.tracker = tracker;
    }
    @Override
    public void onUpdate(double tpf) {
        tracker.UpdateWindow();
    }
}
