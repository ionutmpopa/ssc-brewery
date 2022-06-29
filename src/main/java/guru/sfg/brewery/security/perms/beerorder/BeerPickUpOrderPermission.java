package guru.sfg.brewery.security.perms.beerorder;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority('pickup.order.update') " +
    "OR hasAuthority('customer.pickup.order.update') " +
    "AND @beerOrderAuthenticationManager.customerIdMatches(authentication, #customerId)")
public @interface BeerPickUpOrderPermission {
}
