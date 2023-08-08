package cn.alphahub.dtt.plus.util.support;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Jackson original property naming strategy
 *
 * @author weasley
 * @since 1.1.0
 */
public class OriginalPropertyNamingStrategy extends PropertyNamingStrategies.NamingBase {

    public static List<AnnotatedField> getAnnotatedFields(AnnotatedMethod method) {
        @SuppressWarnings("deprecation") Iterable<AnnotatedField> fields = ((AnnotatedClass) method.getTypeContext()).fields();
        return StreamSupport.stream(fields.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public String translate(String propertyName) {
        return propertyName;
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        List<AnnotatedField> annotatedFields = getAnnotatedFields(method);
        for (AnnotatedField annotatedField : annotatedFields) {
            if (defaultName.equalsIgnoreCase(annotatedField.getName())) {
                return annotatedField.getName();
            }
        }
        return super.nameForGetterMethod(config, method, defaultName);
    }

    @Override
    public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
        return super.nameForField(config, field, defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        List<AnnotatedField> annotatedFields = getAnnotatedFields(method);
        for (AnnotatedField annotatedField : annotatedFields) {
            if (defaultName.equalsIgnoreCase(annotatedField.getName())) {
                return annotatedField.getName();
            }
        }
        return super.nameForSetterMethod(config, method, defaultName);
    }

    @Override
    public String nameForConstructorParameter(MapperConfig<?> config, AnnotatedParameter ctorParam, String defaultName) {
        return super.nameForConstructorParameter(config, ctorParam, defaultName);
    }
}
