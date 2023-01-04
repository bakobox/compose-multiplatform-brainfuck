package app.bakobox.brainfuck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun Brainfuck() {
    var input by remember { mutableStateOf("+++++++++[->++++++++>+++++++++++>+++++<<<]>.>++.+++++++..+++.>-.------------.<++++++++.--------.+++.------.--------.>+.") }
    var result by remember { mutableStateOf<Output>(Output.Success("")) }
    val platformName = getPlatformName()

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Hello, ${platformName}!")
        TextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 300.dp)
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { result = Interpreter.execute(input) }
        ) {
            Text(text = "Execute")
        }
        when (val output = result) {
            is Output.Success -> {
                Text(text = output.outputString)
            }
            is Output.Error -> {
                Text(text = output.cause.message ?: "error", color = Color.Red)
            }
        }
    }
}
