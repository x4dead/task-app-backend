package kg.ab.service.task;

import kg.ab.dto.BaseResponse;
import kg.ab.entity.Task;
import kg.ab.service.task.dto.TaskDTO;
import kg.ab.service.task.dto.UpdateTaskReq;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TaskService {
    BaseResponse<String> addTask(TaskDTO req);

    BaseResponse<List<Task>> getTasks();

    BaseResponse<Task> getTask(Long id);

    BaseResponse<String> deleteTask(Long id);

    BaseResponse<String> updateTask(Long id, UpdateTaskReq req);
}
