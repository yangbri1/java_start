// file path to this entity class
package io.housing.expense_tracker.entities;

import lombok.AllArgsConstructor;
// lombok annotations to reduce boilerplate code for getter methods, setter methods, and equals/hashCode methods
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Could use @Data annotation since it includes both @Getter & @Setter ...
** but it also has other excess Lombok annotaitons such as @ToString, @EqualsAndhashCode, and @RequiredArgsConstructor ...
** ... @Data is often discouraged for Entity classes as it defaults 'equals()' and hashCode() implementations which can cause issues w/ lazy loading & identity maps */
@Getter
@Setter
// lombok annotations to generate the constructors
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Property {

}
