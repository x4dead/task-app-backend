package kg.ab.commons;

import kg.ab.entity.Task;
import kg.ab.service.task.dto.TaskDTO;
import kg.ab.service.task.dto.UpdateTaskReq;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@UtilityClass
@Slf4j
public class Util {
    public Task taskDtoToEntity(TaskDTO dto) {
        return new Task(null, dto.getStatus(), dto.getDescription(), dto.getName()
        );
    }

    public Object getUpdateMessage(UpdateTaskReq req, Task task, boolean isGetUpdatedTask) {
        var desc = req.getDescription();
        var status = req.getStatus();
        var name = req.getName();
        List<String> message = new java.util.ArrayList<>(List.of());
        if (desc != null) {
            task.setDescription(desc);
            message.add("description");
        }
        if (name != null) {
            task.setName(name);
            message.add("name");
        }
        if (status != null) {
            task.setStatus(status);
            message.add("status");
        }

        return isGetUpdatedTask ? task : "Task " + message + " successfully updated";
    }


}
