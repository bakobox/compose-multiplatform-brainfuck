import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import app.bakobox.brainfuck.Brainfuck
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("Brainfuck") {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box(modifier = Modifier.height(48.dp))
        Brainfuck()
    }
}
