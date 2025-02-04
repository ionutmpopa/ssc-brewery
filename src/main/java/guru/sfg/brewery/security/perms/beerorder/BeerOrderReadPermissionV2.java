package guru.sfg.brewery.security.perms.beerorder;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by jt on 7/7/20.
 */

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('order.read', 'customer.order.read')")
public @interface BeerOrderReadPermissionV2 {
}
