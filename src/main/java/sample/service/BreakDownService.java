package sample.service;

import sample.dto.Result;
import sample.model.Wine;

public interface BreakDownService {
    Result execute(Wine wine);
}
