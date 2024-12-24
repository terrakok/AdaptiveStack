package com.github.terrakok.adaptivestack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Immutable
interface AdaptiveStackScope {

    /**
     * The element's size proportional to its [weight] relative to other weighted sibling
     * elements in the [AdaptiveStackScope]. The parent will divide the available space remaining after measuring
     * unweighted child elements and distribute it according to this weight.
     * When [fill] is true, the element will be forced to occupy the whole size allocated to it.
     * Otherwise, the element is allowed to be smaller - this will result in [AdaptiveStackScope] being smaller,
     * as the unused allocated size will not be redistributed to other siblings.
     *
     * @param weight The proportional size to give to this element, as related to the total of
     * all weighted siblings. Must be positive.
     * @param fill When `true`, the element will occupy the whole space allocated.
     */
    @Stable
    fun Modifier.weight(
        weight: Float,
        fill: Boolean = true
    ): Modifier
}

private class AdaptiveRowScopeInstance(private val row: RowScope) : AdaptiveStackScope {
    @Stable
    override fun Modifier.weight(
        weight: Float,
        fill: Boolean
    ): Modifier {
        with(row) {
            return this@weight.weight(weight)
        }
    }
}

private class AdaptiveColumnScopeInstance(private val column: ColumnScope) : AdaptiveStackScope {
    @Stable
    override fun Modifier.weight(
        weight: Float,
        fill: Boolean
    ): Modifier {
        with(column) {
            return this@weight.weight(weight)
        }
    }
}

/**
 * A layout composable that places its children in a vertical sequence if it's width more than height
 * and in a horizontal sequence otherwise.
 *
 * @param modifier The modifier to be applied to the Column.
 */
@Composable
fun VerticalAdaptiveStack(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable AdaptiveStackScope.() -> Unit
) {
    BoxWithConstraints {
        val localContent = movableContentOf(content)
        if (maxWidth > maxHeight) {
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment
            ) {
                val adaptiveScope = remember { AdaptiveColumnScopeInstance(this) }
                localContent(adaptiveScope)
            }
        } else {
            Row(
                modifier = modifier,
                horizontalArrangement = verticalArrangement.toHorizontal(),
                verticalAlignment = horizontalAlignment.toVertical()
            ) {
                val adaptiveScope = remember { AdaptiveRowScopeInstance(this) }
                localContent(adaptiveScope)
            }
        }
    }
}

/**
 * A layout composable that places its children in a horizontal sequence if it's width more than height
 * and in a vertical sequence otherwise.
 *
 * @param modifier The modifier to be applied to the Column.
 */
@Composable
fun HorizontalAdaptiveStack(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable AdaptiveStackScope.() -> Unit
) {
    BoxWithConstraints {
        val localContent = movableContentOf(content)
        if (maxWidth <= maxHeight) {
            Column(
                modifier = modifier,
                verticalArrangement = horizontalArrangement.toVertical(),
                horizontalAlignment = verticalAlignment.toHorizontal()
            ) {
                val adaptiveScope = remember { AdaptiveColumnScopeInstance(this) }
                localContent(adaptiveScope)
            }
        } else {
            Row(
                modifier = modifier,
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment
            ) {
                val adaptiveScope = remember { AdaptiveRowScopeInstance(this) }
                localContent(adaptiveScope)
            }
        }
    }
}

private fun Arrangement.Vertical.toHorizontal() = when (this) {
    Arrangement.Top -> Arrangement.Start
    Arrangement.Bottom -> Arrangement.End
    else -> Arrangement.Center
}

private fun Alignment.Vertical.toHorizontal(): Alignment.Horizontal = when (this) {
    Alignment.Top -> Alignment.Start
    Alignment.Bottom -> Alignment.End
    else -> Alignment.CenterHorizontally
}

private fun Arrangement.Horizontal.toVertical(): Arrangement.Vertical = when (this) {
    Arrangement.Start -> Arrangement.Top
    Arrangement.End -> Arrangement.Bottom
    else -> Arrangement.Center
}

private fun Alignment.Horizontal.toVertical(): Alignment.Vertical = when (this) {
    Alignment.Start -> Alignment.Top
    Alignment.End -> Alignment.Bottom
    else -> Alignment.CenterVertically
}
