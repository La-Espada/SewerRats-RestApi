package com.sewerrats.sewerratsapp.service.exceptions;

import jakarta.persistence.PersistenceException;
import org.springframework.data.jpa.domain.AbstractPersistable;

public class ServiceException extends RuntimeException{
    private static final String CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS = "Cannot create entity of type %s (%s) due to database problems!";
    private static final String CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY = "Cannot create entity  due to database problems!";
    private static final String CANNOT_DELETE_DUE_TO_EXISTENCE_PROBLEMS = "Cannot delete the entity of type %s (%s) due to existence problems!";
    private static final String CANNOT_UPDATE_DUE_TO_ENTRY_PROBLEMS ="Cannot update the entity of type %s (%s) due to entry problems!";

    private static final String CANNOT_READ_DUE_TO_PROBLEMS_NOT_EXISTING = "Cannot read entity of type %s (%s) due to not existing!";
    private ServiceException (String message, Throwable rootCause){
        super(message,rootCause);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotCreateEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return  new ServiceException(msg, pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotDeleteEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_DELETE_DUE_TO_EXISTENCE_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return new ServiceException(msg,pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannotUpdateEntity(T entity, PersistenceException pEx){
        String msg = (entity == null)
                ? CANNOT_CREATE_DUE_TO_DATABASE_PROBLEMS_WITH_NULL_ENTITY.formatted(entity.getClass().getSimpleName(), entity)
                : CANNOT_UPDATE_DUE_TO_ENTRY_PROBLEMS.formatted(entity.getClass().getSimpleName(), entity);
        return new ServiceException(msg,pEx);
    }

    public static <T extends AbstractPersistable<?>> ServiceException cannnotReadEntityDueToNotExisting(T entity, PersistenceException pEx){
        String msg = CANNOT_READ_DUE_TO_PROBLEMS_NOT_EXISTING;
        return new ServiceException(msg,pEx);
    }
}
